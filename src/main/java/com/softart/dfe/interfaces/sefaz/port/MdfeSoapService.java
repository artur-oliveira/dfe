package com.softart.dfe.interfaces.sefaz.port;

public interface MdfeSoapService extends SoapService {

    <T> T receptionHom();

    <T> T queryReceiptHom();

    <T> T eventHom();

    <T> T querySituationHom();

    <T> T statusServiceHom();

    <T> T queryUnclosedHom();

    <T> T distributionHom();

    <T> T receptionSyncHom();

    <T> T receptionProd();

    <T> T queryReceiptProd();

    <T> T eventProd();

    <T> T querySituationProd();

    <T> T statusServiceProd();

    <T> T queryUnclosedProd();

    <T> T distributionProd();

    <T> T receptionSyncProd();

}
