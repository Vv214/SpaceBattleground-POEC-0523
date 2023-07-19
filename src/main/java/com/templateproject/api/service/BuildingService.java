package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.controller.BuildingPayload;
import com.templateproject.api.entity.Building;
import com.templateproject.api.repository.BuildingRepository;

public class BuildingService {
  private final BuildingRepository buildingRepository;

  public BuildingService(BuildingRepository buildingRepository) {
    this.buildingRepository = buildingRepository;
  }

  public void create(BuildingPayload bulding) {
    Building building = new Building();
    buildingService.save(building);
  }

}
