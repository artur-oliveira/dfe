package com.softart.dfe.components.process.cte.event.impl.file;

import com.softart.dfe.components.process.cte.event.impl.EventCteProcessFactory;
import com.softart.dfe.interfaces.process.cte.event.AfterEvent;
import com.softart.dfe.interfaces.process.cte.event.BeforeEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileSystemEventCteFactory extends EventCteProcessFactory {

    @Override
    public Collection<BeforeEvent> before() {
        return Collections.singletonList(new FileSystemEventCte());
    }

    @Override
    public Collection<AfterEvent> after() {
        return Arrays.asList(new FileSystemReturnEventCte(), new FileSystemProcEventCte());
    }
}
