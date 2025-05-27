package com.mysterious.simple_web_app_for_aws_deployment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String greet() {
        return "Welcome to Mysterious !!";
    }

    @GetMapping("/info")
    public String aboutMachine() {
        String os = System.getProperty("os.name");
        String version = System.getProperty("os.version");
        String architecture = System.getProperty("os.arch");
        String javaVersion = System.getProperty("java.version");
        String user = System.getProperty("user.name");

        return "OS: " + os + "\n" +
                "Version: " + version + "\n" +
                "Architecture: " + architecture + "\n" +
                "Java Version: " + javaVersion + "\n" +
                "User: " + user;
    }

    @GetMapping("/time")
    public String getCurrentTime() {
        return "Current Time: " + java.time.LocalTime.now();
    }

    @GetMapping("/date")
    public String getCurrentDate() {
        return "Today's Date: " + java.time.LocalDate.now();
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello, " + name + "! Nice to meet you.";
    }

    @GetMapping("/random")
    public String getRandomNumber() {
        int randomNum = (int)(Math.random() * 100) + 1;
        return "Your random number is: " + randomNum;
    }

    @GetMapping("/memory")
    public String getMemoryInfo() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory() / (1024 * 1024); //We convert from bytes to megabytes by dividing by (1024 * 1024)
        long freeMemory = runtime.freeMemory() / (1024 * 1024);
        long usedMemory = totalMemory - freeMemory;

        return "Memory Info:\n" +
                "Total Memory: " + totalMemory + " MB \n"+
                "Free Memory: " + freeMemory + " MB\n" +
                "Used Memory: " + usedMemory + " MB";
    }

    @GetMapping("/cpu")
    public String getCpuInfo() {
        int processors = Runtime.getRuntime().availableProcessors();
        return "Available processors: " + processors;
    }

    @GetMapping("/ip")
    public String getServerIP() {
        try {
            return "Server IP: " + java.net.InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            return "Could not determine server IP";
        }
    }

    @GetMapping("/quote")
    public String getRandomQuote() {
        String[] quotes = {
                "The best way to predict the future is to invent it.",
                "It always seems impossible until it's done.",
                "Simplicity is the ultimate sophistication.",
                "Code is like humor. When you have to explain it, it's bad.",
                "Programming isn't about what you know; it's about what you can figure out."
        };

        int randomIndex = (int)(Math.random() * quotes.length);
        return "Quote of the moment: " + quotes[randomIndex];
    }

    @GetMapping("/uptime")
    public String getUptime() {
        long uptime = java.lang.management.ManagementFactory.getRuntimeMXBean().getUptime();
        long seconds = uptime / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        return "Application uptime: " + hours + " hours, " +
                (minutes % 60) + " minutes, " +
                (seconds % 60) + " seconds";
    }
}