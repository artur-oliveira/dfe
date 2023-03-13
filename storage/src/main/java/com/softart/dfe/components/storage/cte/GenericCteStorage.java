package com.softart.dfe.components.storage.cte;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.components.storage.common.CommonStorage;
import com.softart.dfe.enums.cte.CteReturnCode;
import com.softart.dfe.enums.internal.cte.CteStorageKey;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.storage.cte.CteStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import com.softart.dfe.util.IOUtils;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Objects;

import static java.io.File.separator;

@Log4j2
public abstract class GenericCteStorage extends CommonStorage implements CteStorage {
    @Override
    public void storeDistribution(Store<DistDFeInt> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                String nsu = Objects.nonNull(o.getData().getConsNSU()) ? "ConsNSU_" + o.getData().getConsNSU().getNSU() : Objects.nonNull(o.getData().getDistNSU()) ? o.getData().getDistNSU().getUltNSU() : "";
                getStorageService().writeSend(o, CteStorageKey.CTE_DISTRIBUTION, xmlNameWithTime(nsu));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnDistribution(Store<RetDistDFeInt> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o, CteStorageKey.CTE_DISTRIBUTION, xmlNameWithTime(o.getData().getUltNSU() + "_" + o.getData().getMaxNSU()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEvent(Store<TEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInfEvento()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeSend(o, CteStorageKey.CTE_EVENT, xmlNameWithTime(o.getData().getInfEvento().getChCTe() + "-" + o.getData().getInfEvento().getTpEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnEvent(Store<TRetEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInfEvento()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o, CteStorageKey.CTE_EVENT, xmlNameWithTime(o.getData().getInfEvento().getChCTe() + "-" + o.getData().getInfEvento().getTpEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcEvent(Store<TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getRetEventoCTe()) && Objects.nonNull(o.getXml()) && CteReturnCode.generateProc(o.getData().getRetEventoCTe().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, CteStorageKey.CTE_EVENT, xmlNameWithTime(o.getData().getRetEventoCTe().getInfEvento().getChCTe() + "-" + o.getData().getEventoCTe().getInfEvento().getTpEvento() + "-" + o.getData().getEventoCTe().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeInutilization(Store<TInutCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInfInut()) && Objects.nonNull(o.getXml())) {
                String keyName = String.join("_", o.getData().getInfInut().getMod(), o.getData().getInfInut().getSerie(), o.getData().getInfInut().getNCTIni(), o.getData().getInfInut().getNCTFin());
                getStorageService().writeSend(o.getConfig(), CteStorageKey.CTE_INUTILIZATION, xmlNameWithTime(keyName), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnInutilization(Store<TRetInutCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInfInut()) && Objects.nonNull(o.getXml())) {
                String keyName = String.join("_", o.getData().getInfInut().getMod(), o.getData().getInfInut().getSerie(), o.getData().getInfInut().getNCTIni(), o.getData().getInfInut().getNCTFin());
                getStorageService().writeReturn(o.getConfig(), CteStorageKey.CTE_INUTILIZATION, xmlNameWithTime(keyName), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcInutilization(Store<TProcInutCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getRetInutCTe()) && CteReturnCode.generateProc(o.getData().getRetInutCTe().getInfInut().getCStat()) && Objects.nonNull(o.getXml())) {
                String keyName = String.join("_", o.getData().getInutCTe().getInfInut().getMod(), o.getData().getInutCTe().getInfInut().getSerie(), o.getData().getInutCTe().getInfInut().getNCTIni(), o.getData().getInutCTe().getInfInut().getNCTFin());
                getStorageService().writeProc(o.getConfig(), CteStorageKey.CTE_INUTILIZATION, xmlNameWithTime(keyName), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeQueryReceipt(Store<TConsReciCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeSend(o, CteStorageKey.CTE_QUERY_RECEIPT, xmlNameWithTime(o.getData().getNRec()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    private void storeProcByQueryReceipt(Store<TRetConsReciCTe> o) throws IOException, StorageException {
        if (Objects.isNull(o.getData().getProtCTe())) return;

        String xml = null;
        for (TProtCTe protCTe : o.getData().getProtCTe()) {
            xml = IOUtils.readFileToString(IOUtils.findLastFileByBasePath(String.join(separator, getStorageService().rootPath(o.getConfig()), CteStorageKey.CTE_RECEPTION.getForSend(), protCTe.getInfProt().getChCTe())));
            if (Objects.nonNull(xml)) break;
        }

        if (Objects.isNull(xml)) return;

        TEnviCTe tEnviNFe = CteUnmarshallerFactory.getInstance().enviCte(xml).getValue();

        for (TProtCTe protCTe : o.getData().getProtCTe()) {
            TCteProc proc = new ObjectFactory().createTCteProc();
            proc.setProtCTe(protCTe);
            proc.setCTe(tEnviNFe.getCTe().stream().filter(it -> it.getInfCte().getId().contains(protCTe.getInfProt().getChCTe())).findFirst().orElse(null));
            proc.setVersao(proc.getCTe().getInfCte().getVersao());

            storeProcCte(new XMLStore<>(proc, o.getConfig(), CteMarshallerFactory.getInstance().cteProc(proc)));
        }
    }

    @Override
    public void storeReturnQueryReceipt(Store<TRetConsReciCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o, CteStorageKey.CTE_QUERY_RECEIPT, xmlNameWithTime(o.getData().getNRec()));
                storeProcByQueryReceipt(o);
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeQuerySituation(Store<TConsSitCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeSend(o, CteStorageKey.CTE_QUERY_SITUATION, xmlNameWithTime(o.getData().getChCTe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnQuerySituation(Store<TRetConsSitCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                String accessKey = "";

                if (Objects.nonNull(o.getData().getProtCTe())) {
                    try {
                        accessKey = CteUnmarshallerFactory.getInstance().protCTe(o.getData().getProtCTe().getAny()).getValue().getInfProt().getChCTe();
                    } catch (MarshallException e1) {
                        try {
                            accessKey = CteUnmarshallerFactory.getInstance().protCTeOS(o.getData().getProtCTe().getAny()).getValue().getInfProt().getChCTe();
                        } catch (MarshallException e2) {
                            accessKey = CteUnmarshallerFactory.getInstance().protGTVe(o.getData().getProtCTe().getAny()).getValue().getInfProt().getChCTe();
                        }
                    }
                }

                getStorageService().writeReturn(o, CteStorageKey.CTE_QUERY_SITUATION, xmlNameWithTime(accessKey));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeGtve(Store<TGTVe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                getStorageService().writeSend(o.getConfig(), CteStorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.getData().getInfCte().getId())), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnGtve(Store<TRetGTVe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData().getProtCTe())) {
                getStorageService().writeReturn(o.getConfig(), CteStorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.getData().getProtCTe().getInfProt().getChCTe())), o.getXml());
            } else {
                getStorageService().writeReturn(o.getConfig(), CteStorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(""), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcGtve(Store<TGTVeProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getProtCTe()) && Objects.nonNull(o.getXml()) && CteReturnCode.generateProc(o.getData().getProtCTe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, CteStorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(o.getData().getProtCTe().getInfProt().getChCTe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeCteOs(Store<TCTeOS> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                getStorageService().writeSend(o.getConfig(), CteStorageKey.CTE_RECEPTION_OS, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.getData().getInfCte().getId())), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnCteOs(Store<TRetCTeOS> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                if (Objects.nonNull(o.getData().getProtCTe())) {
                    getStorageService().writeReturn(o.getConfig(), CteStorageKey.CTE_RECEPTION_OS, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.getData().getProtCTe().getInfProt().getChCTe())), o.getXml());
                } else {
                    getStorageService().writeReturn(o.getConfig(), CteStorageKey.CTE_RECEPTION_OS, xmlNameWithTime(""), o.getXml());
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcCteOs(Store<TCteOSProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getProtCTe()) && Objects.nonNull(o.getXml()) && CteReturnCode.generateProc(o.getData().getProtCTe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, CteStorageKey.CTE_RECEPTION_OS, xmlNameWithTime(o.getData().getProtCTe().getInfProt().getChCTe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeCte(Store<TEnviCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                for (int i = 0; i < o.getData().getCTe().size(); i++) {
                    getStorageService().writeSend(o.getConfig(), CteStorageKey.CTE_RECEPTION, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.getData().getCTe().get(i).getInfCte().getId())), o.getXml());
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnCte(Store<TRetEnviCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getInfRec()) && Objects.nonNull(o.getXml())) {
                getStorageService().writeReturn(o.getConfig(), CteStorageKey.CTE_RECEPTION, xmlNameWithTime(o.getData().getInfRec().getNRec()), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcCte(Store<TCteProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getProtCTe()) && Objects.nonNull(o.getXml()) && CteReturnCode.generateProc(o.getData().getProtCTe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, CteStorageKey.CTE_RECEPTION, xmlNameWithTime(o.getData().getProtCTe().getInfProt().getChCTe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeCteSync(Store<TCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                getStorageService().writeSend(o.getConfig(), CteStorageKey.CTE_RECEPTION_SYNC, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.getData().getInfCte().getId())), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnCteSync(Store<TRetCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                if (Objects.nonNull(o.getData().getProtCTe())) {
                    getStorageService().writeReturn(o.getConfig(), CteStorageKey.CTE_RECEPTION_SYNC, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.getData().getProtCTe().getInfProt().getChCTe())), o.getXml());
                } else {
                    getStorageService().writeReturn(o.getConfig(), CteStorageKey.CTE_RECEPTION_SYNC, xmlNameWithTime(""), o.getXml());
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcCteSync(Store<TCteProc> o) throws StorageException {
        storeProcCte(o);
    }

    @Override
    public void storeStatusService(Store<TConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                getStorageService().writeSend(o.getConfig(), CteStorageKey.CTE_STATUS_SERVICE, xmlNameWithTime(), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnStatusService(Store<TRetConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData())) {
                getStorageService().writeReturn(o.getConfig(), CteStorageKey.CTE_STATUS_SERVICE, xmlNameWithTime(), o.getXml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }
}
