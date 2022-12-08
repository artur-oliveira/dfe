package com.softart.dfe.interfaces.sefaz.port;

public interface NfeSoapService extends NfCommonSoapService {

    <T> T homDistribution();

    <T> T prodDistribution();

    <T> T homEpec();

    <T> T prodEpec();

    <T> T homInterestedActor();

    <T> T prodInterestedActor();

    <T> T homCorrectionLetter();

    <T> T prodCorrectionLetter();

    <T> T homManifestation();

    <T> T prodManifestation();

    <T> T queryGtin();

}
