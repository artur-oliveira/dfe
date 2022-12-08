package com.softart.dfe.interfaces.process.nf;

import com.softart.dfe.interfaces.process.DfProcess;
import com.softart.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import com.softart.dfe.interfaces.process.nf.authorization.BeforeAuthorization;
import com.softart.dfe.interfaces.process.nf.cancel.AfterCancel;
import com.softart.dfe.interfaces.process.nf.cancel.BeforeCancel;
import com.softart.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import com.softart.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;
import com.softart.dfe.interfaces.process.nf.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.nf.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.process.nf.epec.AfterEpec;
import com.softart.dfe.interfaces.process.nf.epec.BeforeEpec;
import com.softart.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import com.softart.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;
import com.softart.dfe.interfaces.process.nf.inut.AfterInut;
import com.softart.dfe.interfaces.process.nf.inut.BeforeInut;
import com.softart.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import com.softart.dfe.interfaces.process.nf.manifestation.BeforeManifestation;
import com.softart.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import com.softart.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;
import com.softart.dfe.interfaces.process.nf.query_protocol.AfterQueryProtocol;
import com.softart.dfe.interfaces.process.nf.query_protocol.BeforeQueryProtocol;
import com.softart.dfe.interfaces.process.nf.query_status_service.AfterQueryStatusService;
import com.softart.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;
import com.softart.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import com.softart.dfe.interfaces.process.nf.return_authorization.BeforeReturnAuthorization;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;

import java.util.Collection;

public interface NfProcess extends DfProcess {

    Collection<AfterInut> afterInutilization();

    Collection<BeforeInut> beforeInutilization();

    Collection<AfterCancel> afterCancel();

    Collection<BeforeCancel> beforeCancel();

    Collection<AfterAuthorization> afterAuthorization();

    Collection<BeforeAuthorization> beforeAuthorization();

    Collection<AfterReturnAuthorization> afterReturnAuthorization();

    Collection<BeforeReturnAuthorization> beforeReturnAuthorization();

    Collection<AfterQueryProtocol> afterQueryProtocol();

    Collection<BeforeQueryProtocol> beforeQueryProtocol();

    Collection<AfterQueryStatusService> afterQueryStatusService();

    Collection<BeforeQueryStatusService> beforeQueryStatusService();

    Collection<AfterDistribution> afterDistribution();

    Collection<BeforeDistribution> beforeDistribution();

    Collection<AfterManifestation> afterManifestation();

    Collection<BeforeManifestation> beforeManifestation();

    Collection<AfterCorrectionLetter> afterCorrectionLetter();

    Collection<BeforeCorrectionLetter> beforeCorrectionLetter();

    Collection<AfterEpec> afterEpec();

    Collection<BeforeEpec> beforeEpec();

    Collection<AfterInterestedActor> afterInterestedActor();

    Collection<BeforeInterestedActor> beforeInterestedActor();

    Collection<AfterQueryGtin> afterQueryGtin();

    Collection<BeforeQueryGtin> beforeQueryGtin();

    Collection<AfterSubstituteCancel> afterSubstituteCancel();

    Collection<BeforeSubstituteCancel> beforeSubstituteCancel();
}
