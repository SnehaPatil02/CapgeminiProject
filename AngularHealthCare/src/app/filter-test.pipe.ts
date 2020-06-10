import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterTest'
})
export class FilterTestPipe implements PipeTransform {

  transform(tests: Test[], search: string): Test[] {

    if (search === undefined) {
      return tests;
    } else {
      return tests.filter((test, index) => {
        return test.centerId.toLowerCase().includes(search.toLowerCase());
      });
    }
  }

}
