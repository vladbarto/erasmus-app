export interface RepresentativeModel {
  personId?: string;
  user: UserModel;
  cnp: string;
  name: string;
  phoneNumber: string;
  dateOfBirth: string; // or any
  universityCode: string;
  facultyCode: string;
  country: string;
  city: string;
  // pana aici a tinut de person
  titles: string;
  type: string;
}
