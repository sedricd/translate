package com.sedricd.translate.translator.web;

public interface Translator {

    public String trans(LANG from, LANG targ, String query) throws Exception;

}
