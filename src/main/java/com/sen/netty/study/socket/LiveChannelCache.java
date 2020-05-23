package com.sen.netty.study.socket;

import io.netty.channel.Channel;
import io.netty.util.concurrent.ScheduledFuture;

/**
 * @author: Sen
 * @date 2020/5/23 0023 9:58
 * @description:
 */
public class LiveChannelCache {

    private Channel channel;

    private ScheduledFuture scheduledFuture;

    public LiveChannelCache(Channel channel, ScheduledFuture scheduledFuture) {
        this.channel = channel;
        this.scheduledFuture = scheduledFuture;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public ScheduledFuture getScheduledFuture() {
        return scheduledFuture;
    }

    public void setScheduledFuture(ScheduledFuture scheduledFuture) {
        this.scheduledFuture = scheduledFuture;
    }
}
