package org.example.sq.part1.SmartHomeController.services.security;

import org.example.sq.part1.SmartHomeController.Lockable;
import org.example.sq.part1.SmartHomeController.Openable;
import org.example.sq.part1.SmartHomeController.SmartHomeDevice;

public interface SecurityControlService extends SmartHomeDevice, Openable, Lockable {
}
