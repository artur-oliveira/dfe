package org.dfe.components.storage.cte;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import org.dfe.components.internal.parser.AccessKeyParserFactory;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.components.internal.xml.objectfactory.CteObjectFactoryWrapperFactory;
import org.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import org.dfe.components.storage.common.CommonStorage;
import org.dfe.enums.cte.CteReturnCode;
import org.dfe.enums.internal.cte.CteStorageKey;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.exceptions.xml.MarshallException;
import org.dfe.interfaces.storage.Store;
import org.dfe.interfaces.storage.cte.CteStorage;
import org.dfe.models.internal.storage.StorageResult;
import org.dfe.models.internal.xml.XMLStore;
import org.dfe.util.IOUtils;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Objects;

@Log4j2
public abstract class GenericCteStorage extends CommonStorage implements CteStorage {
    @Override
    public void storeDistribution(Store<DistDFeInt> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                String nsu = Objects.nonNull(o.data().getConsNSU()) ? "ConsNSU_" + o.data().getConsNSU().getNSU() : Objects.nonNull(o.data().getDistNSU()) ? o.data().getDistNSU().getUltNSU() : "";
                getStorageService().writeSend(o, CteStorageKey.CTE_DISTRIBUTION, xmlNameWithTime(nsu));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnDistribution(Store<RetDistDFeInt> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, CteStorageKey.CTE_DISTRIBUTION, xmlNameWithTime(o.data().getUltNSU() + "_" + o.data().getMaxNSU()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEvent(Store<TEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfEvento()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, CteStorageKey.CTE_EVENT, xmlNameWithTime(o.data().getInfEvento().getChCTe() + "-" + o.data().getInfEvento().getTpEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnEvent(Store<TRetEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfEvento()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, CteStorageKey.CTE_EVENT, xmlNameWithTime(o.data().getInfEvento().getChCTe() + "-" + o.data().getInfEvento().getTpEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcEvent(Store<TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getRetEventoCTe()) && Objects.nonNull(o.xml()) && CteReturnCode.generateProc(o.data().getRetEventoCTe().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, CteStorageKey.CTE_EVENT, xmlNameWithTime(o.data().getRetEventoCTe().getInfEvento().getChCTe() + "-" + o.data().getEventoCTe().getInfEvento().getTpEvento() + "-" + o.data().getEventoCTe().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeInutilization(Store<TInutCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfInut()) && Objects.nonNull(o.xml())) {
                String keyName = String.join("_", o.data().getInfInut().getMod(), o.data().getInfInut().getSerie(), o.data().getInfInut().getNCTIni(), o.data().getInfInut().getNCTFin());
                getStorageService().writeSend(o.config(), CteStorageKey.CTE_INUTILIZATION, xmlNameWithTime(keyName), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnInutilization(Store<TRetInutCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfInut()) && Objects.nonNull(o.xml())) {
                String keyName = String.join("_", o.data().getInfInut().getMod(), o.data().getInfInut().getSerie(), o.data().getInfInut().getNCTIni(), o.data().getInfInut().getNCTFin());
                getStorageService().writeReturn(o.config(), CteStorageKey.CTE_INUTILIZATION, xmlNameWithTime(keyName), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcInutilization(Store<TProcInutCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getRetInutCTe()) && CteReturnCode.generateProc(o.data().getRetInutCTe().getInfInut().getCStat()) && Objects.nonNull(o.xml())) {
                String keyName = String.join("_", o.data().getInutCTe().getInfInut().getMod(), o.data().getInutCTe().getInfInut().getSerie(), o.data().getInutCTe().getInfInut().getNCTIni(), o.data().getInutCTe().getInfInut().getNCTFin());
                getStorageService().writeProc(o.config(), CteStorageKey.CTE_INUTILIZATION, xmlNameWithTime(keyName), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeQueryReceipt(Store<TConsReciCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, CteStorageKey.CTE_QUERY_RECEIPT, xmlNameWithTime(o.data().getNRec()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    private void storeProcByQueryReceipt(Store<TRetConsReciCTe> o) throws IOException, StorageException {
        if (Objects.isNull(o.data().getProtCTe())) return;

        String xml = null;
        for (TProtCTe protCTe : o.data().getProtCTe()) {
            xml = IOUtils.readFileToString(getStorageService().getFirstSend(o.config(), CteStorageKey.CTE_RECEPTION, protCTe.getInfProt().getChCTe()).file());
            if (Objects.nonNull(xml)) break;
        }

        if (Objects.isNull(xml)) return;

        TEnviCTe tEnviNFe = CteUnmarshallerFactory.getInstance().enviCte(xml).getValue();

        for (TProtCTe protCTe : o.data().getProtCTe()) {
            TCteProc proc = CteObjectFactoryWrapperFactory.getInstance().cteProc();
            proc.setProtCTe(protCTe);
            proc.setCTe(tEnviNFe.getCTe().stream().filter(it -> it.getInfCte().getId().contains(protCTe.getInfProt().getChCTe())).findFirst().orElse(null));
            proc.setVersao(proc.getCTe().getInfCte().getVersao());

            storeProcCte(new XMLStore<>(proc, o.config(), CteMarshallerFactory.getInstance().cteProc(proc)));
        }
    }

    @Override
    public void storeReturnQueryReceipt(Store<TRetConsReciCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, CteStorageKey.CTE_QUERY_RECEIPT, xmlNameWithTime(o.data().getNRec()));
                storeProcByQueryReceipt(o);
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeQuerySituation(Store<TConsSitCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, CteStorageKey.CTE_QUERY_SITUATION, xmlNameWithTime(o.data().getChCTe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnQuerySituation(Store<TRetConsSitCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                String accessKey = "";

                if (Objects.nonNull(o.data().getProtCTe())) {
                    try {
                        accessKey = CteUnmarshallerFactory.getInstance().protCTe(o.data().getProtCTe().getAny()).getValue().getInfProt().getChCTe();
                    } catch (MarshallException e1) {
                        try {
                            accessKey = CteUnmarshallerFactory.getInstance().protCTeOS(o.data().getProtCTe().getAny()).getValue().getInfProt().getChCTe();
                        } catch (MarshallException e2) {
                            accessKey = CteUnmarshallerFactory.getInstance().protGTVe(o.data().getProtCTe().getAny()).getValue().getInfProt().getChCTe();
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
            if (Objects.nonNull(o.data())) {
                getStorageService().writeSend(o.config(), CteStorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getInfCte().getId())), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnGtve(Store<TRetGTVe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data().getProtCTe()) && Objects.nonNull(o.data().getProtCTe().getInfProt().getChCTe())) {
                getStorageService().writeReturn(o.config(), CteStorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getProtCTe().getInfProt().getChCTe())), o.xml());
            } else {
                getStorageService().writeReturn(o.config(), CteStorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(""), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcGtve(Store<TGTVeProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getProtCTe()) && Objects.nonNull(o.xml()) && CteReturnCode.generateProc(o.data().getProtCTe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, CteStorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(o.data().getProtCTe().getInfProt().getChCTe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeCteOs(Store<TCTeOS> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                getStorageService().writeSend(o.config(), CteStorageKey.CTE_RECEPTION_OS, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getInfCte().getId())), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnCteOs(Store<TRetCTeOS> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                if (Objects.nonNull(o.data().getProtCTe()) && Objects.nonNull(o.data().getProtCTe().getInfProt().getChCTe())) {
                    getStorageService().writeReturn(o.config(), CteStorageKey.CTE_RECEPTION_OS, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getProtCTe().getInfProt().getChCTe())), o.xml());
                } else {
                    getStorageService().writeReturn(o.config(), CteStorageKey.CTE_RECEPTION_OS, xmlNameWithTime(""), o.xml());
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcCteOs(Store<TCteOSProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getProtCTe()) && Objects.nonNull(o.xml()) && CteReturnCode.generateProc(o.data().getProtCTe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, CteStorageKey.CTE_RECEPTION_OS, xmlNameWithTime(o.data().getProtCTe().getInfProt().getChCTe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeCte(Store<TEnviCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                for (int i = 0; i < o.data().getCTe().size(); i++) {
                    getStorageService().writeSend(o.config(), CteStorageKey.CTE_RECEPTION, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getCTe().get(i).getInfCte().getId())), o.xml());
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnCte(Store<TRetEnviCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfRec()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o.config(), CteStorageKey.CTE_RECEPTION, xmlNameWithTime(o.data().getInfRec().getNRec()), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcCte(Store<TCteProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getProtCTe()) && Objects.nonNull(o.xml()) && CteReturnCode.generateProc(o.data().getProtCTe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, CteStorageKey.CTE_RECEPTION, xmlNameWithTime(o.data().getProtCTe().getInfProt().getChCTe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeCteSync(Store<TCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                getStorageService().writeSend(o.config(), CteStorageKey.CTE_RECEPTION_SYNC, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getInfCte().getId())), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnCteSync(Store<TRetCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                if (Objects.nonNull(o.data().getProtCTe()) && Objects.nonNull(o.data().getProtCTe().getInfProt().getChCTe())) {
                    getStorageService().writeReturn(o.config(), CteStorageKey.CTE_RECEPTION_SYNC, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getProtCTe().getInfProt().getChCTe())), o.xml());
                } else {
                    getStorageService().writeReturn(o.config(), CteStorageKey.CTE_RECEPTION_SYNC, xmlNameWithTime(""), o.xml());
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
            if (Objects.nonNull(o.data())) {
                getStorageService().writeSend(o.config(), CteStorageKey.CTE_STATUS_SERVICE, xmlNameWithTime(), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnStatusService(Store<TRetConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                getStorageService().writeReturn(o.config(), CteStorageKey.CTE_STATUS_SERVICE, xmlNameWithTime(), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }
}
