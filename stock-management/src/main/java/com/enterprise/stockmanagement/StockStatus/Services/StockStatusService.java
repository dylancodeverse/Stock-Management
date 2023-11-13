package com.enterprise.stockmanagement.StockStatus.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.StockStatus.Models.StockStatusModel;
import com.enterprise.stockmanagement.StockStatus.Models.FormStockStatusModel.FormStockStatusModel;

@Service
public class StockStatusService 
{

    @Autowired StockStatusServiceOperation stockStatusServiceOperation ;

    public StockStatusModel getStockStatus(FormStockStatusModel formStockStatusModel) {
        
        StockStatusModel stockStatusModel = new StockStatusModel() ;

        stockStatusModel.setInitialQuantity(stockStatusServiceOperation.getStockStatusQuantity(formStockStatusModel.getBeginDate() ,formStockStatusModel.getArticle() , formStockStatusModel.getStore()));

        stockStatusModel.setFinalQuantity(stockStatusServiceOperation.getStockStatusQuantity(formStockStatusModel.getEndDate() ,formStockStatusModel.getArticle() , formStockStatusModel.getStore()));

        stockStatusModel.setPriceValue(stockStatusServiceOperation.getStockStatusPriceValue(formStockStatusModel.getEndDate() ,formStockStatusModel.getArticle() , formStockStatusModel.getStore()));

        return stockStatusModel ;
    }


}
