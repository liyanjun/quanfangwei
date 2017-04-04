package org.li.common.util.face.result;

import java.util.List;

/**
 * Created by 衍君 on 2017/4/3.
 */
public class CreditCardResult {
    private String image_id = "";
    private String request_id = "";
    private List<CardResult> cards;

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public List getCards() {
        return cards;
    }

    public void setCards(List cards) {
        this.cards = cards;
    }
}
