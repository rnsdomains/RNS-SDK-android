package co.rsk.rnssdk;

import org.web3j.tx.ClientTransactionManager;

import co.rsk.rnssdk.contracts.AbstractResolver;

class AbstractResolverResult {

    private final AbstractResolver resolver;
    private final String resolverAddress;
    private final ClientTransactionManager clientTransactionManager;

    public AbstractResolverResult(final AbstractResolver resolver, final String resolverAddress, final ClientTransactionManager clientTransactionManager) {
        this.resolver = resolver;
        this.resolverAddress = resolverAddress;
        this.clientTransactionManager = clientTransactionManager;
    }

    public String getResolverAddress() {
        return resolverAddress;
    }

    public ClientTransactionManager getClientTransactionManager() {
        return clientTransactionManager;
    }

    public AbstractResolver getResolver() {
        return resolver;
    }


}
