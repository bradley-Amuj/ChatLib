package com.bradley.chatlib;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.google.common.truth.Truth.*;





@RunWith(JUnit4.class)
public class MessageUtilTest {

    @Test
    public void SenderRecipient(){
        String result  = new MessageUtil().getOnetoOne("BBJ","TMAK");
        assert (result).equals("BBJTMAK");


    }


    @Test
    public void RecipientSender(){
        String result  = new MessageUtil().getOnetoOne("TMAK","BBJ");
        assert (result).equals("BBJTMAK");


    }


}