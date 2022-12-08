package com.softart.dfe.interfaces.sefaz.port;

public interface CteSoapService extends SoapService {

    <T> T prodDistribution();

    <T> T homDistribution();

    <T> T prodEvent();

    <T> T homEvent();

    <T> T prodInutilization();

    <T> T homInutilization();

    <T> T prodQueryReceipt();

    <T> T homQueryReceipt();

    <T> T prodQuerySituation();

    <T> T homQuerySituation();

    <T> T prodReception();

    <T> T homReception();

    <T> T prodReceptionGtve();

    <T> T homReceptionGtve();

    <T> T prodReceptionOs();

    <T> T homReceptionOs();

    <T> T prodReceptionSync();

    <T> T homReceptionSync();

    <T> T prodStatusService();

    <T> T homStatusService();


}
