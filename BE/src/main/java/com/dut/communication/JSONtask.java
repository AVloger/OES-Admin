package com.dut.communication;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.List;

@Data
public class JSONtask {
    private String flag;
    private Integer taskId;
    private List<Integer> plugin;
}
