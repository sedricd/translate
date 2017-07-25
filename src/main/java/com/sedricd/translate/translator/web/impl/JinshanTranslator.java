package com.sedricd.translate.translator.web.impl;

import com.alibaba.fastjson.JSONObject;
import com.sedricd.translate.annotation.TranslatorComponent;
import com.sedricd.translate.http.HttpParams;
import com.sedricd.translate.http.HttpPostParams;
import com.sedricd.translate.translator.web.AbstractOnlineTranslator;
import com.sedricd.translate.translator.web.LANG;

@TranslatorComponent(id = "jinshan")
final public class JinshanTranslator extends AbstractOnlineTranslator {

    public JinshanTranslator() {
        langMap.put(LANG.EN, "en");
        langMap.put(LANG.ZH, "zh");
    }

    @Override
    protected String getResponse(LANG from, LANG targ, String query) throws Exception {
        HttpParams params = new HttpPostParams().put("f", langMap.get(from)).put("t", langMap.get(targ)).put("w",
                query);

        return params.send2String("http://fy.iciba.com/ajax.php?a=fy");
    }

    @Override
    protected String parseString(String jsonString) {
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        String result = jsonObject.getJSONObject("content").getString("out");
        return result;
    }
}
