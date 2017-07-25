package com.sedricd.translate.translator.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractOnlineTranslator implements Translator {

    private static Logger logger = LoggerFactory.getLogger(AbstractOnlineTranslator.class);

    protected Map<LANG, String> langMap = new HashMap<>(); // 语言映射，由子类完成

    @Override
    final public String trans(LANG from, LANG targ, String query) throws Exception {
        String response = "";
        try {
            response = getResponse(from, targ, query);
            String result = parseString(response);
            return result;
        } catch (Exception e) {
            logger.error("translate fail : ", e);
            return response;
        }
    }

    abstract protected String getResponse(LANG from, LANG targ, String query) throws Exception;

    abstract protected String parseString(String jsonString);
}
