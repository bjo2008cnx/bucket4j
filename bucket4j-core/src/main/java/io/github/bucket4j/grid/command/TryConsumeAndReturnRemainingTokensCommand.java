package io.github.bucket4j.grid.command;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.BucketConfiguration;
import io.github.bucket4j.BucketState;
import io.github.bucket4j.ConsumptionProbe;
import io.github.bucket4j.grid.GridBucketState;


public class TryConsumeAndReturnRemainingTokensCommand implements GridCommand<ConsumptionProbe> {

    private long tokensToConsume;
    private boolean bucketStateModified = false;

    public TryConsumeAndReturnRemainingTokensCommand(long tokensToConsume) {
        this.tokensToConsume = tokensToConsume;
    }

    @Override
    public ConsumptionProbe execute(GridBucketState gridState) {
        BucketConfiguration configuration = gridState.getBucketConfiguration();
        BucketState state = gridState.getBucketState();
        long currentTimeNanos = configuration.getTimeMeter().currentTimeNanos();
        Bandwidth[] bandwidths = configuration.getBandwidths();

        state.refillAllBandwidth(bandwidths, currentTimeNanos);
        long availableToConsume = state.getAvailableTokens(bandwidths);
        if (tokensToConsume <= availableToConsume) {
            state.consume(bandwidths, tokensToConsume);
            bucketStateModified = true;
            return ConsumptionProbe.consumed(availableToConsume - tokensToConsume);
        } else {
            long nanosToWaitForRefill = state.delayNanosAfterWillBePossibleToConsume(bandwidths, tokensToConsume);
            return ConsumptionProbe.rejected(availableToConsume, nanosToWaitForRefill);
        }
    }

    @Override
    public boolean isBucketStateModified() {
        return bucketStateModified;
    }

}
