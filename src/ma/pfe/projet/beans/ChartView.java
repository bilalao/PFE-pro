/*package ma.pfe.projet.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;

@Named
@RequestScoped
public class ChartView implements Serializable{

	private static final long serialVersionUID = 1L;


    
    private BarChartModel barModel;
   
   
    private LineChartModel animatedModel1;
    private BarChartModel animatedModel2;
    private LineChartModel multiAxisModel;
    private LineChartModel dateModel;
 
    @PostConstruct
    public void init() {
       
    }
 
   
 
    public BarChartModel getBarModel() {
        return barModel;
    }
 
    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }
   
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    public LineChartModel getMultiAxisModel() {
        return multiAxisModel;
    }
 
    public LineChartModel getDateModel() {
        return dateModel;
    }
 
  
 
    
 
 

 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
 
        return model;
    }
 
   
 
    private void createBarModel() {
        barModel = initBarModel();
 
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
 
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
 
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
 
   
 
    
 
    
	
	
	
	
}*/
