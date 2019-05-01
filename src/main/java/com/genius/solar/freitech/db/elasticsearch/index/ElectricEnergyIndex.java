package com.genius.solar.freitech.db.elasticsearch.index;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ElectricEnergyIndex {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate recordDate;
    private BigDecimal total;
    private BigDecimal max;
    private BigDecimal min;
    private BigDecimal ave;
}
