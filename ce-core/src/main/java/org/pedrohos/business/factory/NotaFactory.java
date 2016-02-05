package org.pedrohos.business.factory;

import org.pedrohos.business.notas.NotaDefault;

public interface NotaFactory {
	NotaDefault getService(String service);
}
