import { Operation } from "./operation";

export const operations: Operation[] = [
    new Operation('Crédit','Simulation de crédit à la consommation ou immobilier', 'credit'),
    new Operation('Audit','Audit de tous les comptes domiciliés dans la banque', 'audit'),
    new Operation('Virement', 'Virement de compte à compte entre deux clients', 'virement')
]
