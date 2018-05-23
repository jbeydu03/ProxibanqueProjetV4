import { DOCUMENT } from '@angular/common';
import { Inject } from '@angular/core';

export class Cookie {
    /*
    cle: string;
    valeur: string;

    constructor(cle: string, valeur: string, @Inject(DOCUMENT) private document) {
        this.cle = cle;
        this.valeur = valeur;

    }

    private setCookie(name: string, value: string) {
        this.document.cookie = `${name}=${value}`;
    }

 
    private getCookie(name: string = ''): string {
        const allCookiesString = this.document.cookie;
        const index1 = allCookiesString.indexOf(name);
        if (index1 !== -1) {
            let index2 = allCookiesString.indexOf(';', index1);
            index2 = index2 === -1 ? allCookiesString.length : index2;
            const cookieString = allCookiesString.slice(index1, index2);
            return cookieString.split('=')[1];
        }
    }

*/}