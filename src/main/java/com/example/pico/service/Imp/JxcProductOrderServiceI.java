package com.example.pico.service.Imp;

import com.example.pico.bean.JxcProduct;
import com.example.pico.bean.JxcProductOrder;

import java.util.Map;

public interface JxcProductOrderServiceI {
    public Map get(JxcProductOrder jxcProductOrder, String id);
}
