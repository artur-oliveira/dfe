package org.dfe.components.internal.mdfe;

import org.dfe.interfaces.internal.mdfe.MdfeRouteService;

/**
 * The MdfeRouteFactory class provides a static method to get an instance of the MdfeRouteService interface.
 */
public abstract class MdfeRouteFactory implements MdfeRouteService {

    /**
     * The function returns an instance of the MdfeRouteService class.
     *
     * @return An instance of the `MdfeRouteService` class is being returned. The `getInstance()` method is a static method
     * that returns a single instance of the `MdfeRouteService` class, which is created and stored in the `Holder` class.
     * This is an implementation of the Singleton design pattern, which ensures that only one instance of the class is
     * created and used throughout the application.
     */
    public static MdfeRouteService getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * The class is a holder for a singleton instance of the MdfeRouteImpl class.
     */
    private final static class Holder {
        final static MdfeRouteService INSTANCE = new MdfeRouteServiceImpl();
    }

}
