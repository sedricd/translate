package com.sedricd.translate.factory;

import java.net.URISyntaxException;

import com.sedricd.translate.exception.DupIdException;
import com.sedricd.translate.translator.web.Translator;

final public class TranslatorFactory extends AbstractTranslatorFactory{

	public TranslatorFactory() throws ClassNotFoundException, InstantiationException, IllegalAccessException, DupIdException, URISyntaxException {
		super();
	}

	@Override
	public Translator get(String id) {
		return translatorMap.get(id);
	}

}
