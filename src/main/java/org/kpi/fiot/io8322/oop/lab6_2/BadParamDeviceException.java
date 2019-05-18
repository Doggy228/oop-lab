package org.kpi.fiot.io8322.oop.lab6_2;

public class BadParamDeviceException extends RuntimeException {
    private Device device;
    private String errorField;
    private String errorValue;

    public BadParamDeviceException(Device device, String errorField, String errorValue) {
        super("Bad value [" + errorValue + "] in field #" + errorField + (device == null ? "" : " device #" + device.getId()));
        this.device = device;
        this.errorField = errorField;
        this.errorValue = errorValue;
    }

    public Device getDevice() {
        return device;
    }

    public String getErrorField() {
        return errorField;
    }

    public String getErrorValue() {
        return errorValue;
    }
}
