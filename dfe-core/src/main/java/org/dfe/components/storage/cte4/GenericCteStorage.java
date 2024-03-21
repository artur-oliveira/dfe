package org.dfe.components.storage.cte4;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send400.*;
import org.dfe.components.internal.parser.AccessKeyParserFactory;
import org.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import org.dfe.components.storage.common.CommonStorage;
import org.dfe.enums.cte.CteReturnCode;
import org.dfe.enums.internal.cte.Cte4StorageKey;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.exceptions.xml.MarshallException;
import org.dfe.interfaces.storage.Store;
import org.dfe.interfaces.storage.cte4.CteStorage;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class GenericCteStorage extends CommonStorage implements CteStorage {
    @Override
    public void storeDistribution(Store<DistDFeInt> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                String nsu = Objects.nonNull(o.data().getConsNSU()) ? "ConsNSU_" + o.data().getConsNSU().getNSU() : Objects.nonNull(o.data().getDistNSU()) ? o.data().getDistNSU().getUltNSU() : "";
                getStorageService().writeSend(o, Cte4StorageKey.CTE_DISTRIBUTION, xmlNameWithTime(nsu));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnDistribution(Store<RetDistDFeInt> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, Cte4StorageKey.CTE_DISTRIBUTION, xmlNameWithTime(o.data().getUltNSU() + "_" + o.data().getMaxNSU()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEvent(Store<TEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfEvento()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, Cte4StorageKey.CTE_EVENT, xmlNameWithTime(o.data().getInfEvento().getChCTe() + "-" + o.data().getInfEvento().getTpEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnEvent(Store<TRetEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfEvento()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, Cte4StorageKey.CTE_EVENT, xmlNameWithTime(o.data().getInfEvento().getChCTe() + "-" + o.data().getInfEvento().getTpEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcEvent(Store<TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getRetEventoCTe()) && Objects.nonNull(o.xml()) && CteReturnCode.generateProc(o.data().getRetEventoCTe().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, Cte4StorageKey.CTE_EVENT, xmlNameWithTime(o.data().getRetEventoCTe().getInfEvento().getChCTe() + "-" + o.data().getEventoCTe().getInfEvento().getTpEvento() + "-" + o.data().getEventoCTe().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }


    @Override
    public void storeQuerySituation(Store<TConsSitCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, Cte4StorageKey.CTE_QUERY_SITUATION, xmlNameWithTime(o.data().getChCTe()));
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
                        accessKey = CteUnmarshallerFactory.getInstance().protCTe400(o.data().getProtCTe().getAny()).getValue().getInfProt().getChCTe();
                    } catch (MarshallException e1) {
                        try {
                            accessKey = CteUnmarshallerFactory.getInstance().protCTeOS400(o.data().getProtCTe().getAny()).getValue().getInfProt().getChCTe();
                        } catch (MarshallException e2) {
                            accessKey = CteUnmarshallerFactory.getInstance().protGTVe400(o.data().getProtCTe().getAny()).getValue().getInfProt().getChCTe();
                        }
                    }
                }

                getStorageService().writeReturn(o, Cte4StorageKey.CTE_QUERY_SITUATION, xmlNameWithTime(accessKey));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeGtve(Store<TGTVe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                getStorageService().writeSend(o.config(), Cte4StorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getInfCte().getId())), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnGtve(Store<TRetGTVe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data().getProtCTe()) && Objects.nonNull(o.data().getProtCTe().getInfProt().getChCTe())) {
                getStorageService().writeReturn(o.config(), Cte4StorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getProtCTe().getInfProt().getChCTe())), o.xml());
            } else {
                getStorageService().writeReturn(o.config(), Cte4StorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(""), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcGtve(Store<TGTVeProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getProtCTe()) && Objects.nonNull(o.xml()) && CteReturnCode.generateProc(o.data().getProtCTe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, Cte4StorageKey.CTE_RECEPTION_GTVE, xmlNameWithTime(o.data().getProtCTe().getInfProt().getChCTe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeCteOs(Store<TCTeOS> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                getStorageService().writeSend(o.config(), Cte4StorageKey.CTE_RECEPTION_OS, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getInfCte().getId())), o.xml());
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
                    getStorageService().writeReturn(o.config(), Cte4StorageKey.CTE_RECEPTION_OS, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getProtCTe().getInfProt().getChCTe())), o.xml());
                } else {
                    getStorageService().writeReturn(o.config(), Cte4StorageKey.CTE_RECEPTION_OS, xmlNameWithTime(""), o.xml());
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
                getStorageService().writeProc(o, Cte4StorageKey.CTE_RECEPTION_OS, xmlNameWithTime(o.data().getProtCTe().getInfProt().getChCTe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeCteSync(Store<TCTe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                getStorageService().writeSend(o.config(), Cte4StorageKey.CTE_RECEPTION_SYNC, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getInfCte().getId())), o.xml());
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
                    getStorageService().writeReturn(o.config(), Cte4StorageKey.CTE_RECEPTION_SYNC, xmlNameWithTime(AccessKeyParserFactory.cte().fromId(o.data().getProtCTe().getInfProt().getChCTe())), o.xml());
                } else {
                    getStorageService().writeReturn(o.config(), Cte4StorageKey.CTE_RECEPTION_SYNC, xmlNameWithTime(""), o.xml());
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcCteSync(Store<TCteProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getProtCTe()) && Objects.nonNull(o.xml()) && CteReturnCode.generateProc(o.data().getProtCTe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, Cte4StorageKey.CTE_RECEPTION_SYNC, xmlNameWithTime(o.data().getProtCTe().getInfProt().getChCTe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeStatusService(Store<TConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                getStorageService().writeSend(o.config(), Cte4StorageKey.CTE_STATUS_SERVICE, xmlNameWithTime(), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnStatusService(Store<TRetConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data())) {
                getStorageService().writeReturn(o.config(), Cte4StorageKey.CTE_STATUS_SERVICE, xmlNameWithTime(), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }
}
