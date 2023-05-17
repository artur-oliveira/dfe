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
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, MdfeStorageKey.MDFE_DISTRIBUTION, xmlNameWithTime(o.data().getUltNSU()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendDistribution(Store<TDistDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                String nsu = o.data().getUltNSU();
                getStorageService().writeSend(o, MdfeStorageKey.MDFE_DISTRIBUTION, xmlNameWithTime(nsu));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetEvent(Store<TRetEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfEvento()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, MdfeStorageKey.MDFE_EVENT, xmlNameWithTime(String.join("-", o.data().getInfEvento().getChMDFe(), o.data().getInfEvento().getTpEvento(), o.data().getInfEvento().getNSeqEvento())));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendEvent(Store<TEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfEvento()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, MdfeStorageKey.MDFE_EVENT, xmlNameWithTime(String.join("-", o.data().getInfEvento().getChMDFe(), o.data().getInfEvento().getTpEvento(), o.data().getInfEvento().getNSeqEvento())));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcEvent(Store<TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getRetEventoMDFe()) && Objects.nonNull(o.xml()) && MdfeReturnCode.generateProc(o.data().getRetEventoMDFe().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, MdfeStorageKey.MDFE_EVENT, xmlNameWithTime(String.join("-", o.data().getEventoMDFe().getInfEvento().getChMDFe(), o.data().getEventoMDFe().getInfEvento().getTpEvento(), o.data().getEventoMDFe().getInfEvento().getNSeqEvento())));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetQueryReceipt(Store<TRetConsReciMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, MdfeStorageKey.MDFE_QUERY_RECEIPT, xmlNameWithTime(o.data().getNRec()));
                storeProcByQueryReceipt(o);
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    private void storeProcByQueryReceipt(Store<TRetConsReciMDFe> o) throws IOException, StorageException {
        if (Objects.isNull(o.data().getProtMDFe())) return;

        String xml;
        TProtMDFe prot = o.data().getProtMDFe();

        xml = IOUtils.readFileToString(IOUtils.findLastFileByBasePath(String.join(IOUtils.separator(), getStorageService().rootPath(o.config()), MdfeStorageKey.MDFE_RECEPTION.getForSend(), prot.getInfProt().getChMDFe())));

        if (Objects.isNull(xml)) return;

        TEnviMDFe envi = MdfeUnmarshallerFactory.getInstance().sendReception(xml).getValue();
        TMdfeProc proc = new ObjectFactory().createTMdfeProc();
        proc.setProtMDFe(prot);
        proc.setMDFe(envi.getMDFe());
        proc.setVersao(envi.getVersao());

        storeProcMdfe(new XMLStore<>(proc, o.config(), MdfeMarshallerFactory.getInstance().procMdfe(proc)));
    }

    @Override
    public void storeSendQueryReceipt(Store<TConsReciMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, MdfeStorageKey.MDFE_QUERY_RECEIPT, xmlNameWithTime(o.data().getNRec()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetQuerySituation(Store<TRetConsSitMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                String accessKey = "";

                if (Objects.nonNull(o.data().getProtMDFe())) {
                    accessKey = MdfeUnmarshallerFactory.getInstance().protMdfe(o.data().getProtMDFe().getAny()).getValue().getInfProt().getChMDFe();
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
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, MdfeStorageKey.MDFE_QUERY_SITUATION, xmlNameWithTime(""));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetQueryUnclosed(Store<TRetConsMDFeNaoEnc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, MdfeStorageKey.MDFE_QUERY_UNCLOSED, xmlNameWithTime());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendQueryUnclosed(Store<TConsMDFeNaoEnc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, MdfeStorageKey.MDFE_QUERY_UNCLOSED, xmlNameWithTime(Functions.coalesce(o.data().getCNPJ(), o.data().getCPF(), "")));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendMdfe(Store<TEnviMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                getStorageService().writeSend(o.config(), MdfeStorageKey.MDFE_RECEPTION, xmlNameWithTime(AccessKeyParserFactory.mdfe().fromId(o.data().getMDFe().getInfMDFe().getId())), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnSendMdfe(Store<TRetEnviMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfRec()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o.config(), MdfeStorageKey.MDFE_RECEPTION, xmlNameWithTime(o.data().getInfRec().getNRec()), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcMdfe(Store<TMdfeProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getProtMDFe()) && Objects.nonNull(o.xml()) && MdfeReturnCode.generateProc(o.data().getProtMDFe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, MdfeStorageKey.MDFE_RECEPTION, xmlNameWithTime(o.data().getProtMDFe().getInfProt().getChMDFe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeMdfe(Store<TMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                getStorageService().writeSend(o.config(), MdfeStorageKey.MDFE_RECEPTION_SYNC, xmlNameWithTime(AccessKeyParserFactory.mdfe().fromId(o.data().getInfMDFe().getId())), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnMdfe(Store<TRetMDFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                if (Objects.nonNull(o.data().getProtMDFe())) {
                    getStorageService().writeReturn(o.config(), MdfeStorageKey.MDFE_RECEPTION_SYNC, xmlNameWithTime(AccessKeyParserFactory.mdfe().fromId(o.data().getProtMDFe().getInfProt().getChMDFe())), o.xml());
                } else {
                    getStorageService().writeReturn(o.config(), MdfeStorageKey.MDFE_RECEPTION_SYNC, xmlNameWithTime(), o.xml());
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
            if (Objects.nonNull(o.data())) {
                getStorageService().writeSend(o.config(), MdfeStorageKey.MDFE_STATUS_SERVICE, xmlNameWithTime(), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnStatusService(Store<TRetConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                getStorageService().writeReturn(o.config(), MdfeStorageKey.MDFE_STATUS_SERVICE, xmlNameWithTime(), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }
}
