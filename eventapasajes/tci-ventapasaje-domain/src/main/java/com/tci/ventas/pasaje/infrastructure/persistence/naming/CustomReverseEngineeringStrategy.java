package com.tci.ventas.pasaje.infrastructure.persistence.naming;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;
import org.hibernate.mapping.MetaAttribute;

import com.tci.ventas.pasaje.infrastructure.persistence.util.DateUtil;
import com.tci.ventas.pasaje.util.Constant;

public class CustomReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

	public CustomReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
		super(delegate);
	}

	@Override
	public String tableToClassName(TableIdentifier tableIdentifier) {
		String tablePrefix = findPrefixTable(tableIdentifier.getName());
		String tableName = tableIdentifier.getName();
		if(tablePrefix != tableName ){
			return super.tableToClassName(new  TableIdentifier(tableIdentifier.getName().replaceAll(tablePrefix, "")));
		}else{
			return super.tableToClassName(tableIdentifier);
		}
	}
	
	private String findPrefixTable(String tableName){
		List<String> tablePrefixList = new ArrayList<String>();
		String appPrefix = Constant.APPLICACION_PREFIX;
		String separator = Constant.SEPARATOR_TABLE_NAME;
		tablePrefixList.add(appPrefix+Constant.MASTER_TABLE_PREFIX+separator);
		tablePrefixList.add(appPrefix+Constant.DETAIL_TABLE_PREFIX+separator);
		tablePrefixList.add(appPrefix+Constant.RELATION_TABLE_PREFIX+separator);
		
		for(String prefix : tablePrefixList){
			if(tableName.startsWith(prefix) || tableName.toUpperCase().startsWith(prefix.toUpperCase())){
				return prefix;
			}
		}
		return tableName;
	}

	@Override
	public boolean excludeColumn(TableIdentifier identifier, String columnName) {
		List<String> excludedColumns = new ArrayList<String>();
		excludedColumns.add(Constant.CREATIVE_USER_COLUMN);
		excludedColumns.add(Constant.CREATION_DATE_COLUMN);
		excludedColumns.add(Constant.MODIFIER_USER_COLUMN);
		excludedColumns.add(Constant.MODIFICATION_DATE_COLUMN);
		return excludedColumns.contains(columnName) ||  excludedColumns.contains(columnName.toLowerCase());
	}

	@Override
	public Map tableToMetaAttributes(TableIdentifier tableIdentifier) {
		@SuppressWarnings("unchecked")
	    Map<String, MetaAttribute> metaAttributes = super.tableToMetaAttributes(tableIdentifier);

	    if(metaAttributes == null) {
	    	metaAttributes = new HashMap<String, MetaAttribute>();
	    }
	    
		// Base Class
		MetaAttribute extendsAttribute = new MetaAttribute("extends");
		extendsAttribute.addValue(Constant.JPA_ENTITY_BASE);
		metaAttributes.put("extends", extendsAttribute);

		// JavaDoc
		MetaAttribute javadocsAttribute = new MetaAttribute("class-description");
		String description = "@author "+Constant.ENTITY_GENERATOR_USER + "\n"+
							 "@date   "+DateUtil.format(DateUtil.FMT_WEB(), new Date());
		javadocsAttribute.addValue(description);
		metaAttributes.put("class-description", javadocsAttribute);

		return metaAttributes;
	}
	
}
