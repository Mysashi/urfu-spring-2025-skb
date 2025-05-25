package com.example.demo.controller;

import com.example.demo.metrics.MetricsCollector;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Timed
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private MetricsCollector metricsCollector;

    @GetMapping
    public double game() {

        metricsCollector.setTimer("game", "gameMethodExecTime");
        return metricsCollector.getTotalGames().count();

    }

    @PostMapping("/doom")
    public void getDoom() {
        metricsCollector.incrementDoom();
    }

    @PostMapping("/nomansky")
    public void getNoManSky() {
        metricsCollector.incrementNoManSky();
    }

    @PostMapping("/minecraft")
    public void getMinecraft() {
        metricsCollector.incrementMinecraft();
    }

    @GetMapping("/doom")
    public double getDoomCount() {
        return metricsCollector.getDoomCount();
    }

    @GetMapping("/nomansky")
    public double getNoManSkyCount() {
        return metricsCollector.getNomanskyCount();
    }

    @GetMapping("/minecraft")
    public double getMinecraftCount() {
        return metricsCollector.getMinecraftCount();
    }
}
