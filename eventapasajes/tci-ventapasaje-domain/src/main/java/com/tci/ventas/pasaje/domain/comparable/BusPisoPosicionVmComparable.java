package com.tci.ventas.pasaje.domain.comparable;

import java.util.Comparator;

import com.tci.ventas.pasaje.domain.viewmodel.vm.BusPisoPosicionVm;

public class BusPisoPosicionVmComparable implements Comparator<BusPisoPosicionVm> {

	@Override
	public int compare(BusPisoPosicionVm o1, BusPisoPosicionVm o2) {
		// TODO Auto-generated method stub
		return o1.getIdPosicion().compareTo(o2.getIdPosicion());
		
	}

}
