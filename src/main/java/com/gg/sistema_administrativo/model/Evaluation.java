package com.gg.sistema_administrativo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;
    private LocalDate currentDate;
    private LocalDate nextEvaluation;
    @ElementCollection
    private List<Integer> generalData;
    @ElementCollection
    private List<Boolean> qualityData; //Estados de los checkbox
    @ElementCollection
    private List<Integer> timeData;
    @ElementCollection
    private List<Integer> warrantyData;
    public Evaluation(){}
    public Evaluation(Supplier supplier, LocalDate currentDate, LocalDate nextEvaluation, List<Integer> generalData, List<Boolean> qualityData, List<Integer> timeData, List<Integer> warrantyData){
        this.supplier = supplier;
        this.currentDate = currentDate;
        this.nextEvaluation = nextEvaluation;
        this.generalData = generalData;
        this.qualityData = qualityData;
        this.timeData = timeData;
        this.warrantyData = warrantyData;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public LocalDate getNextEvaluation() {
        return nextEvaluation;
    }

    public void setNextEvaluation(LocalDate nextEvaluation) {
        this.nextEvaluation = nextEvaluation;
    }

    public List<Integer> getGeneralData() {
        return generalData;
    }

    public void setGeneralData(List<Integer> generalData) {
        this.generalData = generalData;
    }

    public List<Boolean> getQualityData() {
        return qualityData;
    }

    public void setQualityData(List<Boolean> qualityData) {
        this.qualityData = qualityData;
    }

    public List<Integer> getTimeData() {
        return timeData;
    }

    public void setTimeData(List<Integer> timeData) {
        this.timeData = timeData;
    }

    public List<Integer> getWarrantyData() {
        return warrantyData;
    }

    public void setWarrantyData(List<Integer> warrantyData) {
        this.warrantyData = warrantyData;
    }
}
