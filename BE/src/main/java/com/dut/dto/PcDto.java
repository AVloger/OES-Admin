package com.dut.dto;

import lombok.Data;

@Data
public class PcDto {
    private Integer id;

    private String ip;

    private Integer groupId;

    private String accountName;

    private String accountPassword;

    private String status;

    private Integer clientFlag;

    private Integer manageFlag;

}
