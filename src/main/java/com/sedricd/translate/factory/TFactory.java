package com.sedricd.translate.factory;

import com.sedricd.translate.translator.web.Translator;

public interface TFactory {
	Translator get(String id);
}
