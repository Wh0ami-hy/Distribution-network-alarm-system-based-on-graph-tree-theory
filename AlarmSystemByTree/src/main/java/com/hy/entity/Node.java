package com.hy.entity;

import java.io.Serializable;
import java.math.BigDecimal;


public class Node implements Serializable {
    private Integer node_id;
    private String node_name;
    private String fault_info;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Float current;
    private Float electric_field;
    private Float temperature;
    private Float humidity;
    private Float battery_voltage;
    private Float solar_voltage;
    private String create_time;

    public Node() {
    }

    public Node(Integer node_id, String node_name, String fault_info, BigDecimal latitude, BigDecimal longitude, Float current, Float electric_field, Float temperature, Float humidity, Float battery_voltage, Float solar_voltage, String create_time) {
        this.node_id = node_id;
        this.node_name = node_name;
        this.fault_info = fault_info;
        this.latitude = latitude;
        this.longitude = longitude;
        this.current = current;
        this.electric_field = electric_field;
        this.temperature = temperature;
        this.humidity = humidity;
        this.battery_voltage = battery_voltage;
        this.solar_voltage = solar_voltage;
        this.create_time = create_time;
    }

    public Integer getNode_id() {
        return node_id;
    }

    public void setNode_id(Integer node_id) {
        this.node_id = node_id;
    }

    public String getNode_name() {
        return node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }

    public String getFault_info() {
        return fault_info;
    }

    public void setFault_info(String fault_info) {
        this.fault_info = fault_info;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Float getCurrent() {
        return current;
    }

    public void setCurrent(Float current) {
        this.current = current;
    }

    public Float getElectric_field() {
        return electric_field;
    }

    public void setElectric_field(Float electric_field) {
        this.electric_field = electric_field;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getBattery_voltage() {
        return battery_voltage;
    }

    public void setBattery_voltage(Float battery_voltage) {
        this.battery_voltage = battery_voltage;
    }

    public Float getSolar_voltage() {
        return solar_voltage;
    }

    public void setSolar_voltage(Float solar_voltage) {
        this.solar_voltage = solar_voltage;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Node{" +
                "node_id=" + node_id +
                ", node_name='" + node_name + '\'' +
                ", fault_info='" + fault_info + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", current=" + current +
                ", electric_field=" + electric_field +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", battery_voltage=" + battery_voltage +
                ", solar_voltage=" + solar_voltage +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}

