import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';


@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {

    canActivate(route: ActivatedRouteSnapshot): boolean {
        const expectedRoleArray = route.data.expectedRoleTypes;
        const userDetails = JSON.parse(localStorage.getItem('details'));
        let expectedRole: string;
        for (const index in expectedRoleArray) {
            if (userDetails && userDetails.role === expectedRoleArray[index]) {
                expectedRole = expectedRoleArray[index];
            }
        }
        if (userDetails && userDetails.role === expectedRole) {
            return true;
        } else {
            return false;
        }
    }
}
