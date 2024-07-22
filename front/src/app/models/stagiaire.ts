import { Formation } from './formation';
import { Ordinateur } from './ordinateur';

export class Stagiaire {
    constructor(
        public id?: number,
        public firstName?: string,
        public lastName?: string,
        public email?: string,
        public login?: string,
        public password?: string,
        public formation?: Formation,
        public ordinateur?: Ordinateur,
    ) {}
}