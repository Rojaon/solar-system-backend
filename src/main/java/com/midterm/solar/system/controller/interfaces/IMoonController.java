package com.midterm.solar.system.controller.interfaces;

import com.midterm.solar.system.model.Moon;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IMoonController {
    public List<Moon> getAllMoons();
    public void saveMoon(Moon moon);
    public void deleteMoon(String moonName);
}
