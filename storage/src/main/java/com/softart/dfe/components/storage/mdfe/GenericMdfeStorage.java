package com.softart.dfe.components.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.*;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.MdfeUnmarshallerFactory;
import com.softart.dfe.components.storage.common.CommonStorage;
import com.softart.dfe.enums.internal.mdfe.MdfeStorageKey;
import com.softart.dfe.enums.mdfe.MdfeReturnCode;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import com.softart.dfe.util.Functions;
import com.softart.dfe.util.IOUtils;

import java.io.IOException;
import java.util.Objects;

public abstract class GenericMdfeStorage extends CommonStorage implements MdfeStorage {
    @Override
    public void storeRetDistribution(Store<TRetDistDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o, MdfeStorageKey.MDFE_DISTRIBUTION, xmlNameWithTime(o.getData().getUltNSU()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendDistribution(Store<TDistDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                String nsu = o.getData().getUltNSU();
                getStorageService().writeSend(o, MdfeStorageKey.MDFE_DISTRIBUTION, xmlNameWithTime(nsu));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetEvent(Store<TRetEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInfEvento()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o, MdfeStorageKey.MDFE_EVENT, xmlNameWithTime(o.getData().getInfEvento().getChMDFe() + "-" + o.getData().getInfEvento().getTpEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendEvent(Store<TEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInfEvento()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeSend(o, MdfeStorageKey.MDFE_EVENT, xmlNameWithTime(o.getData().getInfEvento().getChMDFe() + "-" + o.getData().getInfEvento().getTpEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcEvent(Store<TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getRetEventoMDFe()) && Objects.nonNull(o.getXml()) && MdfeReturnCode.generateProc(o.getData().getRetEventoMDFe().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, MdfeStorageKey.MDFE_EVENT, xmlNameWithTime(o.getData().getRetEventoMDFe().getInfEvento().getChMDFe() + "-" + o.getData().getEventoMDFe().getInfEvento().getTpEvento() + "-" + o.getData().getEventoMDFe().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetQueryReceipt(Store<TRetConsReciMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o, MdfeStorageKey.MDFE_QUERY_RECEIPT, xmlNameWithTime(o.getData().getNRec()));
                storeProcByQueryReceipt(o);
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    private void storeProcByQueryReceipt(Store<TRetConsReciMDFe> o) throws IOException, StorageException {
        if (Objects.isNull(o.getData().getProtMDFe())) return;

        String xml;
        TProtMDFe prot = o.getData().getProtMDFe();

        xml = IOUtils.readFileToString(IOUtils.findLastFileByBasePath(String.join(IOUtils.separator(), getStorageService().rootPath(o.getConfig()), MdfeStorageKey.MDFE_RECEPTION.getForSend(), prot.getInfProt().getChMDFe())));

        if (Objects.isNull(xml)) return;

        TEnviMDFe envi = MdfeUnmarshallerFactory.getInstance().sendReception(xml).getValue();
        TMdfeProc proc = new ObjectFactory().createTMdfeProc();
        proc.setProtMDFe(prot);
        proc.setMDFe(envi.getMDFe());
        proc.setVersao(envi.getVersao());

        storeProcMdfe(new XMLStore<>(proc, o.getConfig(), MdfeMarshallerFactory.getInstance().procMdfe(proc)));
    }

    @Override
    public void storeSendQueryReceipt(Store<TConsReciMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeSend(o, MdfeStorageKey.MDFE_QUERY_RECEIPT, xmlNameWithTime(o.getData().getNRec()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetQuerySituation(Store<TRetConsSitMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                String accessKey = "";

                if (Objects.nonNull(o.getData().getProtMDFe())) {
                    accessKey = MdfeUnmarshallerFactory.getInstance().protMdfe(o.getData().getProtMDFe().getAny()).getValue().getInfProt().getChMDFe();
                }

                getStorageService().writeReturn(o, MdfeStorageKey.MDFE_QUERY_SITUATION, xmlNameWithTime(accessKey));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendQuerySituation(Store<TConsSitMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeSend(o, MdfeStorageKey.MDFE_QUERY_SITUATION, xmlNameWithTime(""));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetQueryUnclosed(Store<TRetConsMDFeNaoEnc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o, MdfeStorageKey.MDFE_QUERY_UNCLOSED, xmlNameWithTime());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendQueryUnclosed(Store<TConsMDFeNaoEnc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeSend(o, MdfeStorageKey.MDFE_QUERY_UNCLOSED, xmlNameWithTime(Functions.coalesce(o.getData().getCNPJ(), o.getData().getCPF(), "")));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendMdfe(Store<TEnviMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                getStorageService().writeSend(o.getConfig(), MdfeStorageKey.MDFE_RECEPTION, xmlNameWithTime(AccessKeyParserFactory.mdfe().fromId(o.getData().getMDFe().getInfMDFe().getId())), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnSendMdfe(Store<TRetEnviMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInfRec()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o.getConfig(), MdfeStorageKey.MDFE_RECEPTION, xmlNameWithTime(o.getData().getInfRec().getNRec()), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcMdfe(Store<TMdfeProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getProtMDFe()) && Objects.nonNull(o.getXml()) && MdfeReturnCode.generateProc(o.getData().getProtMDFe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, MdfeStorageKey.MDFE_RECEPTION, xmlNameWithTime(o.getData().getProtMDFe().getInfProt().getChMDFe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeMdfe(Store<TMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                getStorageService().writeSend(o.getConfig(), MdfeStorageKey.MDFE_RECEPTION_SYNC, xmlNameWithTime(AccessKeyParserFactory.mdfe().fromId(o.getData().getInfMDFe().getId())), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnMdfe(Store<TRetMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                if (Objects.nonNull(o.getData().getProtMDFe())) {
                    getStorageService().writeReturn(o.getConfig(), MdfeStorageKey.MDFE_RECEPTION_SYNC, xmlNameWithTime(AccessKeyParserFactory.mdfe().fromId(o.getData().getProtMDFe().getInfProt().getChMDFe())), o.getXml());
                } else {
                    getStorageService().writeReturn(o.getConfig(), MdfeStorageKey.MDFE_RECEPTION_SYNC, xmlNameWithTime(), o.getXml());
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcMdfeSync(Store<TMdfeProc> o) throws StorageException {
        storeProcMdfe(o);
    }

    @Override
    public void storeStatusService(Store<TConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                getStorageService().writeSend(o.getConfig(), MdfeStorageKey.MDFE_STATUS_SERVICE, xmlNameWithTime(), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnStatusService(Store<TRetConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                getStorageService().writeReturn(o.getConfig(), MdfeStorageKey.MDFE_STATUS_SERVICE, xmlNameWithTime(), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }
}
