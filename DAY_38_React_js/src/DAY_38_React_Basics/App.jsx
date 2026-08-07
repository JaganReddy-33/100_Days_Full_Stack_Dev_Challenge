import Navbar from './Components/Navbar/Navbar';
import ProfileCard from "./Components/ProfileCard/ProfileCard";
import Counter from "./Components/Counter/Counter";




const arr = [
  {
    profileImg: "https://avatars.githubusercontent.com/u/5550850?v=4",
    name: "Brad Traversy",
    role: "Full-Stack Web Developer & Educator",
    location: "United States",
    skills: ["JavaScript", "React", "Node.js", "Express", "MongoDB", "HTML", "CSS"],
    GitHub: "https://github.com/bradtraversy",
  },
  {
    profileImg: "https://avatars.githubusercontent.com/u/1045274?v=4",
    name: "Colby Fayock",
    role: "Senior Full Stack Engineer",
    location: "United States",
    skills: ["JavaScript", "React", "Next.js", "Node.js", "Express", "HTML", "CSS"],
    GitHub: "https://github.com/colbyfayock",
  },
  {
    profileImg: "https://avatars.githubusercontent.com/u/11507599?v=4",
    name: "Thibaud Ducasse",
    role: "Software Developer",
    location: "London, United Kingdom",
    skills: ["TypeScript", "JavaScript", "React", "Node.js", "Express", "HTML", "CSS"],
    GitHub: "https://github.com/tducasse",
  },
  {
    profileImg: "https://avatars.githubusercontent.com/u/63742054?v=4",
    name: "Hassan El Mghari",
    role: "Full-Stack Software Engineer",
    location: "Canada",
    skills: ["TypeScript", "React", "Next.js", "Node.js", "Express", "MongoDB", "Tailwind"],
    GitHub: "https://github.com/nutlope",
  },
];


const App = () => {
  return (
    <>
    <Navbar />

    <div style={{display:"flex", gap:"20px", flexWrap:"wrap", padding:"20px"}}>
      {arr.map((profile, index)=>(<ProfileCard key={index} user={profile} />))}
    </div>


    <Counter />
    </>
  );
};

export default App;
