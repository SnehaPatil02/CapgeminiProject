import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterCenter'
})
export class FilterCenterPipe implements PipeTransform {

  transform(centers: Center[], search: string): Center[] {

      if (search === undefined) {
        return centers;
      } else {
        return centers.filter((center, index) => {
          return center.centerId.toLowerCase().includes(search.toLowerCase());
        });
      }
    }
  }


