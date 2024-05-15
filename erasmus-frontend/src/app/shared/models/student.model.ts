export interface StudentModel {
  personId?: string;
  userId: string;
  cnp: string;
  name: string;
  phoneNumber: string;
  dateOfBirth: string; // or any
  universityCode: string;
  facultyCode: string;
  country: string;
  city: string;
  // pana aici a tinut de person
  matriculationNumber: number;
  yearOfStudy: number;
  hasLanguageCertificate: boolean;
  gpa: number;
  hasReexaminations: boolean;
}
