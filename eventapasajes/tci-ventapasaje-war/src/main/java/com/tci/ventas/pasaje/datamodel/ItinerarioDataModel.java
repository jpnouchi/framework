package com.tci.ventas.pasaje.datamodel;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.ItinerarioRsl;

public class ItinerarioDataModel extends ListDataModel<ItinerarioRsl> implements SelectableDataModel<ItinerarioRsl>{

	public ItinerarioDataModel() {  
    }  
  
    public ItinerarioDataModel(List<ItinerarioRsl> data) {  
        super(data);
    }  
      
    @Override  
    public ItinerarioRsl getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        List<ItinerarioRsl> itinerarios = (List<ItinerarioRsl>) getWrappedData();  
          
        for(ItinerarioRsl itinerario : itinerarios) {  
            if(itinerario.getIdItinerario().equals(rowKey))  
                return itinerario;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(ItinerarioRsl itinerario) {  
        return itinerario.getIdItinerario();  
    }  

}
