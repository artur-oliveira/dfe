package com.softart.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import com.softart.dfe.components.storage.common.CommonStorage;
import com.softart.dfe.enums.internal.nf.NFStorageKey;
import com.softart.dfe.enums.nf.NFReturnCode;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.storage.nf.common.NfCommonStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import com.softart.dfe.util.IOUtils;

import java.io.IOException;
import java.util.Objects;

import static java.io.File.separator;

public abstract class GenericNfCommonStorage extends CommonStorage implements NfCommonStorage {

    @Override
    public void storeProcCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getEvento()) && Objects.nonNull(o.getData().getRetEvento()) && Objects.nonNull(o.getXml()) && NFReturnCode.generateProc(o.getData().getRetEvento().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.getData().getEvento().getInfEvento().getChNFe() + "-" + o.getData().getEvento().getInfEvento().getTpEvento() + "-" + o.getData().getEvento().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && !o.getData().getRetEvento().isEmpty() && Objects.nonNull(o.getXml())) {
                for (int i = 0; i < o.getData().getRetEvento().size(); i++) {
                    getStorageService().writeReturn(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.getData().getRetEvento().get(i).getInfEvento().getChNFe() + "-" + o.getData().getRetEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && !o.getData().getEvento().isEmpty() && Objects.nonNull(o.getXml())) {
                for (int i = 0; i < o.getData().getEvento().size(); i++) {
                    getStorageService().writeSend(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.getData().getEvento().get(i).getInfEvento().getChNFe() + "-" + o.getData().getEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcInut(Store<TProcInutNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInutNFe()) && Objects.nonNull(o.getData().getRetInutNFe()) && Objects.nonNull(o.getXml()) && NFReturnCode.generateProc(o.getData().getRetInutNFe().getInfInut().getCStat())) {
                String keyName = String.join("_", o.getData().getInutNFe().getInfInut().getMod(), o.getData().getInutNFe().getInfInut().getSerie(), o.getData().getInutNFe().getInfInut().getNNFIni(), o.getData().getInutNFe().getInfInut().getNNFFin());
                getStorageService().writeProc(o.getConfig(), NFStorageKey.NF_INUTILIZATION, xmlNameWithTime(keyName), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetInut(Store<TRetInutNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInfInut()) && Objects.nonNull(o.getXml())) {
                String keyName = String.join("_", o.getData().getInfInut().getMod(), o.getData().getInfInut().getSerie(), o.getData().getInfInut().getNNFIni(), o.getData().getInfInut().getNNFFin());
                getStorageService().writeReturn(o.getConfig(), NFStorageKey.NF_INUTILIZATION, xmlNameWithTime(keyName), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEnvInut(Store<TInutNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInfInut()) && Objects.nonNull(o.getXml())) {
                String keyName = String.join("_", o.getData().getInfInut().getMod(), o.getData().getInfInut().getSerie(), o.getData().getInfInut().getNNFIni(), o.getData().getInfInut().getNNFFin());
                getStorageService().writeSend(o.getConfig(), NFStorageKey.NF_INUTILIZATION, xmlNameWithTime(keyName), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcNfe(Store<TNfeProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getNFe()) && Objects.nonNull(o.getData().getProtNFe()) && Objects.nonNull(o.getData().getProtNFe().getInfProt()) && Objects.nonNull(o.getXml()) && NFReturnCode.generateProc(o.getData().getProtNFe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, NFStorageKey.NF_AUTHORIZATION, xmlNameWithTime(o.getData().getProtNFe().getInfProt().getChNFe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetNfe(Store<TRetEnviNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getProtNFe()) && Objects.nonNull(o.getData().getProtNFe().getInfProt()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o.getConfig(), NFStorageKey.NF_AUTHORIZATION, xmlNameWithTime(o.getData().getProtNFe().getInfProt().getChNFe()), o.getXml());
            } else if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInfRec()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o.getConfig(), NFStorageKey.NF_AUTHORIZATION, xmlNameWithTime(o.getData().getInfRec().getNRec()), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEnvNfe(Store<TEnviNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                for (int i = 0; i < o.getData().getNFe().size(); i++) {
                    getStorageService().writeSend(o.getConfig(), NFStorageKey.NF_AUTHORIZATION, xmlNameWithTime(AccessKeyParserFactory.nfe().fromId(o.getData().getNFe().get(i).getInfNFe().getId())), o.getXml());
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    protected void storeProcByQueryReceipt(Store<TRetConsReciNFe> o) throws IOException, StorageException {
        if (Objects.isNull(o.getData().getProtNFe())) return;

        String xml = null;
        for (TProtNFe protNFe : o.getData().getProtNFe()) {
            xml = IOUtils.readFileToString(IOUtils.findLastFileByBasePath(String.join(separator, getStorageService().rootPath(o.getConfig()), NFStorageKey.NF_AUTHORIZATION.getForSend(), protNFe.getInfProt().getChNFe())));
            if (Objects.nonNull(xml)) break;
        }

        if (Objects.isNull(xml)) return;

        TEnviNFe tEnviNFe = NfUnmarshallerFactory.getInstance().enviNfe(xml).getValue();
        String versao = tEnviNFe.getNFe().stream().findFirst().orElseThrow(RuntimeException::new).getInfNFe().getVersao();
        for (TProtNFe protNFe : o.getData().getProtNFe()) {
            TNfeProc proc = new ObjectFactory().createTNfeProc();
            proc.setProtNFe(protNFe);
            proc.setNFe(tEnviNFe.getNFe().stream().filter(it -> it.getInfNFe().getId().contains(protNFe.getInfProt().getChNFe())).findFirst().orElse(null));
            proc.setVersao(versao);

            storeProcNfe(new XMLStore<>(proc, o.getConfig(), NfMarshallerFactory.getInstance().procNfe(proc)));
        }
    }

    @Override
    public void storeRetReturnAuthorization(Store<TRetConsReciNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                storeProcByQueryReceipt(o);
                getStorageService().writeReturn(o, NFStorageKey.NF_RETURN_AUTHORIZATION, xmlNameWithTime(o.getData().getNRec()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEnvReturnAuthorization(Store<TConsReciNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeSend(o, NFStorageKey.NF_RETURN_AUTHORIZATION, xmlNameWithTime(o.getData().getNRec()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetQueryProtocol(Store<TRetConsSitNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o, NFStorageKey.NF_QUERY_PROTOCOL, xmlNameWithTime(o.getData().getChNFe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEnvQueryProtocol(Store<TConsSitNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeSend(o, NFStorageKey.NF_QUERY_PROTOCOL, xmlNameWithTime(o.getData().getChNFe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendQueryStatusService(Store<TConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeSend(o, NFStorageKey.NF_QUERY_STATUS_SERVICE, System.currentTimeMillis() + ".xml");
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnQueryStatusService(Store<TRetConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o, NFStorageKey.NF_QUERY_STATUS_SERVICE, System.currentTimeMillis() + ".xml");
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnQueryGtin(Store<TRetConsGTIN> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o, NFStorageKey.NF_QUERY_GTIN, System.currentTimeMillis() + ".xml");
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeQueryGtin(Store<TConsGTIN> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeSend(o, NFStorageKey.NF_QUERY_GTIN, System.currentTimeMillis() + ".xml");
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }
}
