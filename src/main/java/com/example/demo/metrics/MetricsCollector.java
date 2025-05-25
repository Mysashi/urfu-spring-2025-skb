package com.example.demo.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class MetricsCollector {

    private final Counter doomCount;
    private final Counter minecraftCount;
    private final Counter nomanskyCount;
    private final MeterRegistry meterRegistry;

    public Counter getTotalGames() {
        return totalGames;
    }

    Logger logger = LoggerFactory.getLogger(MetricsCollector.class);

    private final Counter totalGames;

    @Autowired
    public MetricsCollector(MeterRegistry meterRegistr) {
        this.meterRegistry = meterRegistr;
        this.totalGames = meterRegistry.counter("totalGames");
        this.doomCount = meterRegistry.counter("doom");
        this.minecraftCount = meterRegistry.counter("minecraft");
        this.nomanskyCount = meterRegistry.counter("nomansky");
    }

    public void incrementDoom() {
        totalGames.increment();
        doomCount.increment();
    }

    public void setTimer(String methodName, String variable) {
        Timer.Sample sample = Timer.start();

        try {
        } finally {

            long time = sample.stop(Timer.builder(variable).register(meterRegistry));
            logger.info(methodName + " выполнен. Время выполнения в наносекундах " + time + " Переменная prometheus: " + variable);
        }
    }

    public void incrementMinecraft() {
        totalGames.increment();
        minecraftCount.increment();
    }

    public void incrementNoManSky() {
        totalGames.increment();
        nomanskyCount.increment();
    }

    public double getDoomCount() {
        return doomCount.count();
    }

    public double getMinecraftCount() {
        return minecraftCount.count();
    }

    public double getNomanskyCount() {
        return nomanskyCount.count();
    }
    }
