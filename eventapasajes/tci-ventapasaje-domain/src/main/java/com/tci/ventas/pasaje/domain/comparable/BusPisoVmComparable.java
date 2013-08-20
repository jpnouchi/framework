package com.tci.ventas.pasaje.domain.comparable;

import java.util.Comparator;

import com.tci.ventas.pasaje.domain.viewmodel.vm.BusPisoVm;

public class BusPisoVmComparable implements Comparator<BusPisoVm> {

	@Override
	public int compare(BusPisoVm o1, BusPisoVm o2) {
		// TODO Auto-generated method stub
		return o1.getIdPiso().compareTo(o2.getIdPiso());
	}

}
