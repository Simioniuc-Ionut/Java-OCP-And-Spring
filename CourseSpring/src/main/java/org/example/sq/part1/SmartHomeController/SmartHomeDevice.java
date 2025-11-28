package org.example.sq.part1.SmartHomeController;

import org.example.sq.part1.SmartHomeController.aop.validation.ValidationId;

public interface SmartHomeDevice {
    String checkWifiConnection(Long... id);
    void connectWifi(String wifiConnection, Long... id);
    void disconnectWifi(Long... id);
}
